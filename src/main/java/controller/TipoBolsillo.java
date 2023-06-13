package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.TipoBolsilloDao;
import models.TipoBolsilloVo;

public class TipoBolsillo extends HttpServlet {

    TipoBolsilloVo r = new TipoBolsilloVo();
    TipoBolsilloDao rd = new TipoBolsilloDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        System.out.println(accion);

        switch (accion) {

            case "TipoBolsillo":
                req.getRequestDispatcher("TipoBolsillo.jsp").forward(req, resp);
                break;
            case "TipoBolsillo-add":
                req.getRequestDispatcher("TipoBolsillo-add.jsp").forward(req, resp);
                break;
            case "TipoBolsillo-modificar":
                req.getRequestDispatcher("TipoBolsillo-modificar.jsp").forward(req, resp);
                break;
            case "abrirForm":
                abrirForm(req, resp);
                break;
            case "listar":
                listar(req, resp);
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String accion = req.getParameter("accion");
        System.out.println("accion");
        switch (accion) {
            case "add":
                // nombre_Usua = req.getParameter("Nombre_Usua");
                add(req, resp);
                break;
            case "modificar":
                // nombre_Usua = req.getParameter("Nombre_Usua");
                modificar(req, resp);
                break;
        }
    }

    private void abrirForm(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("TipoBolsillo-add.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        } catch (Exception e) {
            System.out.println("El formulario NO ha sido abierto" + e.getMessage().toString());
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {
        r = new TipoBolsilloVo();

        String Id_TipoBolsillo = "";
        String Nequi = req.getParameter("Nequi");
        String Daviplata = req.getParameter("Daviplata");
        if (Nequi != null) {
            r.setNequi(req.getParameter("Nequi"));
        }
        if (Daviplata != null) {
            r.setDaviplata(req.getParameter("Daviplata"));
        }
        try {
            rd.registrar(r);
            // sys
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro " + e.getMessage().toString());
        }

    }

        private void modificar (HttpServletRequest req, HttpServletResponse resp) {
        r = new TipoBolsilloVo();

        String Id_TipoBolsillo = "";
        String Nequi = req.getParameter("Nequi");
        String Daviplata = req.getParameter("Daviplata");
        if (Nequi != null) {
            r.setNequi(req.getParameter("Nequi"));
        }
        if (Daviplata != null) {
            r.setDaviplata(req.getParameter("Daviplata"));
        }
        try {
            rd.modificar(r);
            // sys
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro " + e.getMessage().toString());
        }

    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List TipoBolsillo = rd.listar();
            req.setAttribute("TipoBolsillo", TipoBolsillo);
            req.getRequestDispatcher("TipoBolsillo.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }

}
