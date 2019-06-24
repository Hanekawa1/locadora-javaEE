package locadora.diurno.config;

import java.io.*;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import locadora.diurno.controller.*;

@WebFilter(filterName = "AutenticacaoFilter",
		   urlPatterns = {"/*"})	
public class AutenticacaoFilter implements Filter{
	
	@Inject
	private AutenticacaoController autenticacaoController;

	@Override
	public void doFilter(ServletRequest req,
			ServletResponse res,
			FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		String loginURL = request.getContextPath() + "/login.xhtml";
		
		boolean isLoginRequest = request.getRequestURI().equals(loginURL);
		boolean isXHTML = !request.getRequestURI().endsWith(".css.xhtml")
							&& !request.getRequestURI().endsWith(".js.xhtml");
		boolean isAuth = autenticacaoController.isUsuarioAutenticado();
		
		if(isAuth || isLoginRequest || isXHTML == false) {
			//Prosseguir
			chain.doFilter(request, response);
		}else {
			response.sendRedirect(request.getContextPath() + "/login.xhtml");
		}
		
		
		
	}

}
