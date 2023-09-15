/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author lucas.matulis
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name="Usuario.findByEmailSenha",query="SELECT u FROM Usuario u WHERE u.funcionarioEmailfuncionario = :funcionarioEmailfuncionario AND u.senhausuario = :senhausuario"),
    @NamedQuery(name = "Usuario.findByFuncionarioEmailfuncionario", query = "SELECT u FROM Usuario u WHERE u.funcionarioEmailfuncionario = :funcionarioEmailfuncionario"),
    @NamedQuery(name = "Usuario.findBySenhausuario", query = "SELECT u FROM Usuario u WHERE u.senhausuario = :senhausuario")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "funcionario_emailfuncionario")
    private String funcionarioEmailfuncionario;
    @Basic(optional = false)
    @Column(name = "senhausuario")
    private String senhausuario;
    @JoinColumn(name = "funcionario_emailfuncionario", referencedColumnName = "emailfuncionario", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Funcionario funcionario;

    public Usuario() {
    }

    public Usuario(String funcionarioEmailfuncionario) {
        this.funcionarioEmailfuncionario = funcionarioEmailfuncionario;
    }

    public Usuario(String funcionarioEmailfuncionario, String senhausuario) {
        this.funcionarioEmailfuncionario = funcionarioEmailfuncionario;
        this.senhausuario = senhausuario;
    }

    public String getFuncionarioEmailfuncionario() {
        return funcionarioEmailfuncionario;
    }

    public void setFuncionarioEmailfuncionario(String funcionarioEmailfuncionario) {
        this.funcionarioEmailfuncionario = funcionarioEmailfuncionario;
    }

    public String getSenhausuario() {
        return senhausuario;
    }

    public void setSenhausuario(String senhausuario) {
        this.senhausuario = senhausuario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funcionarioEmailfuncionario != null ? funcionarioEmailfuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.funcionarioEmailfuncionario == null && other.funcionarioEmailfuncionario != null) || (this.funcionarioEmailfuncionario != null && !this.funcionarioEmailfuncionario.equals(other.funcionarioEmailfuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Usuario[ funcionarioEmailfuncionario=" + funcionarioEmailfuncionario + " ]";
    }
    
}
