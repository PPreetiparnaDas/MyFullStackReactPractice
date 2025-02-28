package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.json.JSONArray;

import com.dao.DataDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
          
    		throws ServletException, IOException {
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
    	response.setHeader("Access-Control-Allow-Headers", "Content-Type");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String type = request.getParameter("type");

        if (type == null || (!type.equals("user") && !type.equals("photo") && !type.equals("post"))) {
            out.print("[]");
            return;
        }

        List<String> dataList = DataDAO.getDataByType(type); // Call DAO to get data
        System.out.println(dataList);
        JSONArray jsonArray = new JSONArray(dataList);
        System.out.println(jsonArray.toString());
        out.print(jsonArray.toString()); // Send JSON response
        out.flush();
    }
}
