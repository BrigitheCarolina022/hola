package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.MontoDao;
import models.MontoVo;

public class Monto extends HttpServlet {

    MontoVo r = new MontoVo();
    MontoDao rd = new MontoDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        System.out.println(accion);

        switch (accion) {

            case "Monto":
                req.getRequestDispatcher("Monto.jsp").forward(req, resp);
                break;
            case "Monto-add":
                req.getRequestDispatcher("Monto-add.jsp").forward(req, resp);
                break;
            case "Monto-modificar":
                req.getRequestDispatcher("Monto-modificar.jsp").forward(req, resp);
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
            req.getRequestDispatcher("Monto-add.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        } catch (Exception e) {
            System.out.println("El formulario NO ha sido abierto" + e.getMessage().toString());
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {
        r = new MontoVo();

        String Id_Monto = "";
        String Monto = req.getParameter("Monto");
        if (Monto != null) {
            int telefono = Integer.parseInt(Monto);
            r.setMonto(telefono);
        }
        try {
            rd.registrar(r);
            // sys
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro " + e.getMessage().toString());
        }

    }

        private void modificar(HttpServletRequest req, HttpServletResponse resp) {
        r = new MontoVo();

        String Id_Monto = "";
        String Monto = req.getParameter("Monto");
        if (Monto != null) {
            int monto = Integer.parseInt(Monto);
            r.setMonto(monto);
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
            List Monto = rd.listar();
            req.setAttribute("Monto", Monto);
            req.getRequestDispatcher("Monto.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }
}
