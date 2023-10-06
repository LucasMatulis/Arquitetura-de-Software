package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Funcionario;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-29T11:05:31")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, String> nomeDep;
    public static volatile SingularAttribute<Departamento, String> idDep;
    public static volatile ListAttribute<Departamento, Funcionario> funcionarioList;
    public static volatile SingularAttribute<Departamento, String> telefoneDep;

}