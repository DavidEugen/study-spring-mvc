package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //[status-line]
        response.setStatus(HttpServletResponse.SC_OK); //200

        //[response-headers]
//        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 캐쉬 지우기
        response.setHeader("Pragma", "no-cache");
//        response.setHeader("my-header", "hello"); //custom cookie

        content(response);
        cookie(response);

        redirect(response);

        PrintWriter writer = response.getWriter();
        writer.println("ok");
    }

    //content 편의 metod
    private void content(HttpServletResponse response) {

        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2

        //response.setHeader("Content-Type", "text/plain;charset=utf-8"); //이렇게 쓸 수 있으나
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        //response.setContentLength(2); //(생략시 자동 생성)
        //writer.println("ok")시  3이 나오는 이유는 println으로 ln 개행이 들어갔을므로...
    }

    //쿠키 편의 메서드
    private void cookie(HttpServletResponse response) {

        //Set-Cookie: myCookie=good; Max-Age=600;

        // response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600"); //이렇게 쓸 수 있으나

        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);

        response.addCookie(cookie); //Cookie를 마지막에 response에 넣어 준다.

    }

    //redirect 편의 메서드
    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html

        //response.setStatus(HttpServletResponse.SC_FOUND); //302
        //response.setHeader("Location", "/basic/hello-form.html"); // 이렇게 사용할 수 있으나

        response.sendRedirect("/basic/hello-form.html");
    }


}
