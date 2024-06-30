package com.tkmybaitsdemo.demo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", notes = "主键")
    private Integer id;

    @Column(name = "user_name")
    @ApiModelProperty(name = "userName", notes = "用户名称")
    private String userName;

    @ApiModelProperty(name = "age", notes = "用户年龄")
    private Integer age;
}