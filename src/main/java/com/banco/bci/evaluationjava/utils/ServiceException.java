package com.banco.bci.evaluationjava.utils;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends Exception {
    private ResponseEnum data;
    private Object body;
}
