package org.example.mytarocard.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/")
public class TaroFormController extends Controller {
    @Override
    public void init() throws ServletException {
        log("TaroFormController Init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log("TaroFormController doGet");
        req.setAttribute("pageTitle", "타로가좋아");
        req.setAttribute("ogTitle", "타로한번 어떠신가요");
        req.setAttribute("ogDescription", "타로를 좋아해서 밀크티로 타로 밀크티만 마셔요");
        req.setAttribute("ogImageUrl", "/%s/assets/%s".formatted(req.getContextPath(), "taro.jpeg"));
        req.setAttribute("ogPageUrl", req.getContextPath());

        view(req, resp, "form");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //뭔가 처리할 예정


        // 겹칠 확률이 극도로 낮은 임의의 문자열 값
        String uuid = UUID.randomUUID().toString();
        resp.sendRedirect(req.getContextPath() + "/result/%s".formatted(uuid));
    }
}
