package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2019/8/30 10:23.
 */
public class OneServlet extends HttpServlet {
    public OneServlet() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("~~" + getClass().getSimpleName() + ".doPost~~");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("~~" + getClass().getSimpleName() + ".doPost~~");

    }
}
