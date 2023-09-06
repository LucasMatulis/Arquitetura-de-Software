/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author lucas.matulis
 */
@Entity
@Table(name = "departamento")
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByIddepartamento", query = "SELECT d FROM Departamento d WHERE d.iddepartamento = :iddepartamento"),
    @NamedQuery(name = "Departamento.findByNomedepartamento", query = "SELECT d FROM Departamento d WHERE d.nomedepartamento = :nomedepartamento"),
    @NamedQuery(name = "Departamento.findByTelefonedepartamento", query = "SELECT d FROM Departamento d WHERE d.telefonedepartamento = :telefonedepartamento")})
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "iddepartamento")
    private String iddepartamento;
    @Basic(optional = false)
    @Column(name = "nomedepartamento")
    private String nomedepartamento;
    @Column(name = "telefonedepartamento")
    private String telefonedepartamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentoIddepartamento", fetch = FetchType.EAGER)
    private List<Funcionario> funcionarioList;

    public Departamento() {
    }

    public Departamento(String iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public Departamento(String iddepartamento, String nomedepartamento) {
        this.iddepartamento = iddepartamento;
        this.nomedepartamento = nomedepartamento;
    }

    public String getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(String iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public String getNomedepartamento() {
        return nomedepartamento;
    }

    public void setNomedepartamento(String nomedepartamento) {
        this.nomedepartamento = nomedepartamento;
    }

    public String getTelefonedepartamento() {
        return telefonedepartamento;
    }

    public void setTelefonedepartamento(String telefonedepartamento) {
        this.telefonedepartamento = telefonedepartamento;
    }

    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddepartamento != null ? iddepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.iddepartamento == null && other.iddepartamento != null) || (this.iddepartamento != null && !this.iddepartamento.equals(other.iddepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Departamento[ iddepartamento=" + iddepartamento + " ]";
    }
    
}
