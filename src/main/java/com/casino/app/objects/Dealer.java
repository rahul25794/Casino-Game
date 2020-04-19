package com.casino.app.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dealer {
    public Integer id;
    public String name;
    public Integer casinoId;
}