package com.urise.webapp.web;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.SqlStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ResumeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        SqlStorage storage = new SqlStorage("jdbc:postgresql://localhost:5432/resumes", "postgres", "1234");

        List<Resume> resumes = storage.getAllSorted();
        for (Resume resume : resumes) {
            req.setAttribute("name", resume.getFullName());
            req.setAttribute("uuid", resume.getUuid());

        }
        req.getRequestDispatcher("resumes.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
