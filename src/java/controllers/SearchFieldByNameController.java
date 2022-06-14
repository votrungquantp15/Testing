/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import dao.CityDAO;
import dao.FieldCategoryDAO;
import dao.FieldDAO;

import dto.City;
import dto.Field;
import dto.FieldCategory;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author votru
 */
public class SearchFieldByNameController extends HttpServlet {
    
        private static final String SEARCH_SUCCES = "home.jsp";
        private static final String SEARCH_ERROR = "home.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = SEARCH_ERROR;
        String fieldName;
        try {
            //Get category 
            List<FieldCategory> listFieldCategorys = new ArrayList<>();
            FieldCategoryDAO fieldCategoryDAO = new FieldCategoryDAO();
            listFieldCategorys = fieldCategoryDAO.getAllFieldCategory();

            //Get city
            List<City> listCitys = new ArrayList<>();
            CityDAO cityDao = new CityDAO();
            listCitys = cityDao.getAllCity();
            
            fieldName = request.getParameter("name");
            //Get price 
            List<Field> listFields = new ArrayList<>();
            FieldDAO fieldDao = new FieldDAO();
            listFields = fieldDao.getFieldDetailByName(fieldName);

            if (listFields != null) {
                //setAttribute citys

                //setAttribute Fields
                url = SEARCH_SUCCES;
                
                request.setAttribute("FIELD", listFields);
                               
                //setAttribute category
            } else {

            }
        } catch (Exception e) {
            log("Error at LoginController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
