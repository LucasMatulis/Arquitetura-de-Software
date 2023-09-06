/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author lucas.matulis
 */
@Entity
@Table(name = "funcionario")
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByEmailfuncionario", query = "SELECT f FROM Funcionario f WHERE f.emailfuncionario = :emailfuncionario"),
    @NamedQuery(name = "Funcionario.findByNomefuncionario", query = "SELECT f FROM Funcionario f WHERE f.nomefuncionario = :nomefuncionario"),
    @NamedQuery(name = "Funcionario.findByTelefonefuncionario", query = "SELECT f FROM Funcionario f WHERE f.telefonefuncionario = :telefonefuncionario"),
    @NamedQuery(name = "Funcionario.findByCargofuncionario", query = "SELECT f FROM Funcionario f WHERE f.cargofuncionario = :cargofuncionario"),
    @NamedQuery(name = "Funcionario.findBySalariofuncionario", query = "SELECT f FROM Funcionario f WHERE f.salariofuncionario = :salariofuncionario")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "emailfuncionario")
    private String emailfuncionario;
    @Basic(optional = false)
    @Column(name = "nomefuncionario")
    private String nomefuncionario;
    @Column(name = "telefonefuncionario")
    private String telefonefuncionario;
    @Column(name = "cargofuncionario")
    private String cargofuncionario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salariofuncionario")
    private Double salariofuncionario;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "funcionario", fetch = FetchType.EAGER)
    private Usuario usuario;
    @JoinColumn(name = "departamento_iddepartamento", referencedColumnName = "iddepartamento")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Departamento departamentoIddepartamento;

    public Funcionario() {
    }

    public Funcionario(String emailfuncionario) {
        this.emailfuncionario = emailfuncionario;
    }

    public Funcionario(String emailfuncionario, String nomefuncionario) {
        this.emailfuncionario = emailfuncionario;
        this.nomefuncionario = nomefuncionario;
    }

    public String getEmailfuncionario() {
        return emailfuncionario;
    }

    public void setEmailfuncionario(String emailfuncionario) {
        this.emailfuncionario = emailfuncionario;
    }

    public String getNomefuncionario() {
        return nomefuncionario;
    }

    public void setNomefuncionario(String nomefuncionario) {
        this.nomefuncionario = nomefuncionario;
    }

    public String getTelefonefuncionario() {
        return telefonefuncionario;
    }

    public void setTelefonefuncionario(String telefonefuncionario) {
        this.telefonefuncionario = telefonefuncionario;
    }

    public String getCargofuncionario() {
        return cargofuncionario;
    }

    public void setCargofuncionario(String cargofuncionario) {
        this.cargofuncionario = cargofuncionario;
    }

    public Double getSalariofuncionario() {
        return salariofuncionario;
    }

    public void setSalariofuncionario(Double salariofuncionario) {
        this.salariofuncionario = salariofuncionario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Departamento getDepartamentoIddepartamento() {
        return departamentoIddepartamento;
    }

    public void setDepartamentoIddepartamento(Departamento departamentoIddepartamento) {
        this.departamentoIddepartamento = departamentoIddepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailfuncionario != null ? emailfuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.emailfuncionario == null && other.emailfuncionario != null) || (this.emailfuncionario != null && !this.emailfuncionario.equals(other.emailfuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Funcionario[ emailfuncionario=" + emailfuncionario + " ]";
    }
    
}
