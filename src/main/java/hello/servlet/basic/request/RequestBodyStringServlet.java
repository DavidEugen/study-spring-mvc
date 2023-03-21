package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream(); // message Body를 byte 코드로 받아온다.
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        // StreamUtils에서 stream을 string으로 전환하는 util 제공
        // String으로 copy만 할 뿐 Leaves the stream open when done.

        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("ok");

    }
}
