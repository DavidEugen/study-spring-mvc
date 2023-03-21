package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ControllerV2 {
    //v1에서 process후 void 였던 것을 MyView 객체를 반환하도록 하자
    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
