package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticiaDAO;
import model.Noticia;

@WebServlet("/DAOTestes.do")
public class DAOTestes extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Teste de inserÃ§Ã£o:
		Noticia n = new Noticia(123, "Notícia nova",
			"Nova Noticia", "Essa é uma noticia nova");
		
		NoticiaDAO nDAO = new NoticiaDAO();
		
		nDAO.alterar(n);
		
		// Teste de consulta:
		Noticia n1 = nDAO.consultar(123);
		
		//System.out.println(p1.getNome());	}
		
		System.out.println(nDAO.listarNoticias().size());
	}

}