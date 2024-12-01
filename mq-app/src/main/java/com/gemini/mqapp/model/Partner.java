package com.gemini.mqapp.model;

import com.gemini.mqapp.util.PDirection;
import com.gemini.mqapp.util.ProcessFlowType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String alias;
    private String type;
    private PDirection direction;
    private String application;
    private ProcessFlowType processFlowType;
    private String description;


}
