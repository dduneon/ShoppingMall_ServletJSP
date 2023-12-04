package com.nhnacademy.shoppingmall.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "characterEncodingFilter", initParams = {
    @WebInitParam(name = "encoding", value = "UTF-8")
})
public class CharacterEncodingFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    //todo#8 UTF-8 인코딩, initParams의 encoding parameter value값을 charset 으로 지정합니다.
    servletRequest.setCharacterEncoding(
        servletRequest.getServletContext().getInitParameter("encoding"));
    servletResponse.setCharacterEncoding(
        servletRequest.getServletContext().getInitParameter("encoding"));
    filterChain.doFilter(servletRequest, servletResponse);
  }

}
