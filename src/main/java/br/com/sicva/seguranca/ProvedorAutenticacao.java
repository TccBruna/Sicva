/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sicva.seguranca;

import br.com.sicva.dao.UsuariosDao;
import br.com.sicva.model.Usuarios;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

/**
 *
 * @author Rodrigo
 */
@Component
public class ProvedorAutenticacao implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();     
        UsuariosDao usuariosDao = new UsuariosDao();       
        Usuarios usuario = usuariosDao.PesquisarUsuario(name);
        
        if (usuario == null || !usuario.getUsuariosCpf().equalsIgnoreCase(name)) {            
            throw new BadCredentialsException("Username not found.");            
        }

        if (!GenerateMD5.generate(password).equals(usuario.getUsuarioSenha())) {           
            throw new LockedException("Wrong password.");
        }
        if (!usuario.getUsuarioAtivo()) {            
            throw new DisabledException("User is disable");
        }
        List<GrantedAuthority> funcoes = new ArrayList<>();
        funcoes.add(new SimpleGrantedAuthority("ROLE_"+usuario.getFuncao().getFuncaoDescricao()));
        Collection<? extends GrantedAuthority> authorities = funcoes;        
        return new UsernamePasswordAuthenticationToken(name, password, authorities);
        
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
          UsernamePasswordAuthenticationToken.class);
    }

}
