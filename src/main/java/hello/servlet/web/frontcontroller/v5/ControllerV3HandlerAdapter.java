package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter{
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        //frontController에서 supports로 사용 가능 여부 확인 할거다.. 따라서 해당 메소드 실행은 타입이 맞다는 전제 성립
        ControllerV3 controller = (ControllerV3) handler;

        //controller.process();
        return null;
    }
}
