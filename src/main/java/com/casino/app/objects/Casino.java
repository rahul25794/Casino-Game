package com.casino.app.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Casino {
    public Integer id;
    public String name;
    public Double balance;
}