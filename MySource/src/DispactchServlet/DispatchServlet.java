package DispactchServlet;

import java.util.ArrayList;
import java.util.List;

//定义一个Adapter接口
interface HandlerAdapter {
    public boolean supports(Object handler);

    public void handle(Object handler);
}

//以下是三种Controller实现
interface Controller {

}

class HttpController implements Controller {
    public void doHttpHandler() {
        System.out.println("http...");
    }
}

class SimpleController implements Controller {
    public void doSimplerHandler() {
        System.out.println("simple...");
    }
}

class AnnotationController implements Controller {
    public void doAnnotationHandler() {
        System.out.println("annotation...");
    }
}


//下面编写适配器类

class SimpleHandlerAdapter implements HandlerAdapter {


    public void handle(Object handler) {
        ((SimpleController) handler).doSimplerHandler();
    }

    public boolean supports(Object handler) {
        return (handler instanceof SimpleController);
    }

}


class HttpHandlerAdapter implements HandlerAdapter {

    public void handle(Object handler) {
        ((HttpController) handler).doHttpHandler();
    }

    public boolean supports(Object handler) {
        return (handler instanceof HttpController);
    }

}


class AnnotationHandlerAdapter implements HandlerAdapter {

    public void handle(Object handler) {
        ((AnnotationController) handler).doAnnotationHandler();
    }

    public boolean supports(Object handler) {

        return (handler instanceof AnnotationController);
    }

}


public class DispatchServlet {

    public static List<HandlerAdapter> handlerAdapters = new ArrayList<HandlerAdapter>();

    public DispatchServlet() {
        handlerAdapters.add(new AnnotationHandlerAdapter());
        handlerAdapters.add(new HttpHandlerAdapter());
        handlerAdapters.add(new SimpleHandlerAdapter());
    }


    public void doDispatch() {

        //此处模拟SpringMVC从request取handler的对象，仅仅new出，可以出，
        //不论实现何种Controller，适配器总能经过适配以后得到想要的结果
//      HttpController controller = new HttpController();
//      AnnotationController controller = new AnnotationController();
        SimpleController controller = new SimpleController();
        //得到对应适配器
        HandlerAdapter adapter = getHandler(controller);
        //通过适配器执行对应的controller对应方法
        adapter.handle(controller);

    }

    public HandlerAdapter getHandler(Controller controller) {
        for (HandlerAdapter adapter : this.handlerAdapters) {
            if (adapter.supports(controller)) {
                return adapter;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new DispatchServlet().doDispatch();
    }

}