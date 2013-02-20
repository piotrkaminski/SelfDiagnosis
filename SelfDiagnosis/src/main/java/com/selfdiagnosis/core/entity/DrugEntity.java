package com.selfdiagnosis.core.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.selfdiagnosis.SelfDiagnosisConstants;

/**
 * Drug entity.
 * 
 * @author mmieszkowski
 * 
 */
@Entity
@Table(name = "Drug")
public class DrugEntity extends SelfDiagnosisEntity implements Serializable {

    /**
     * Serial.
     */
    private static final long serialVersionUID = -3633559288015181469L;

    /**
     * Primary key..
     */
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Name of the drug.
     */
    @NotBlank
    @Length(max = SelfDiagnosisConstants.DRUG_NAME_LENGTH_MAX)
    @Column(name = "name", unique = false, nullable = false)
    private String name;

    /**
     * Description of the drug.
     */
    @Column(name = "description", unique = false, nullable = true)
    private String description;

    /**
     * Drug's contraindications.
     */
    @ManyToMany
    @JoinTable(name = "DrugContraindication", joinColumns = @JoinColumn(name = "drug_id"),
            inverseJoinColumns = @JoinColumn(name = "contraindication_id"))
    private Collection<ContraindicationEntity> contraindicationCollection;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
