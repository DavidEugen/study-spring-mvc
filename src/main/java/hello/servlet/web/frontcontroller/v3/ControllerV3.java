package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    //paramMap을 사용하므로써 Servlet의 종속성에서 탈피
    //비지니스 로직에서는 Servlet의 기술이 필요 없음. 필요하다면 비지니스 로직과 뷰에서 관심 가질 model
    ModelView process(Map<String, String> paramMap);
}
