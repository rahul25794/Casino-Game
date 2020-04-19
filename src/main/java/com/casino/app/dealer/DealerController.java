package com.casino.app.dealer;

import java.util.List;

import com.casino.app.dealer.DealerRepository;
import com.casino.app.objects.Casino;
import com.casino.app.objects.Dealer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping(DealerController.BASE_URL)
public class DealerController {
    public static final String BASE_URL = "dealers";
    @Autowired
    public DealerRepository dealerRepo;

    @GetMapping(value = "/{id}")
    public Dealer get(@PathVariable(value = "id", required = true) Integer id) throws Exception {
        return dealerRepo.get(id);
    }

    @PostMapping()
    public Dealer addDealer(@RequestParam(required = true) Integer casinoId,
            @RequestParam(required = true) String name) throws Exception {
        return dealerRepo.create(name, casinoId);
    }
}