package com.residencia.dell.controllers;

import com.residencia.dell.entities.Orders;
import com.residencia.dell.services.OrdersService;
import com.residencia.dell.vo.NotaFiscalVO;
import com.residencia.dell.vo.OrdersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/{id}")
    public ResponseEntity<Orders> findById(@PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(ordersService.findById(id),headers, HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<List<Orders>> findAll() throws Exception{
//
//        HttpHeaders headers = new HttpHeaders();
//        return new ResponseEntity<>(ordersService.findAll(),headers,HttpStatus.OK);
//    }

    //COM PAGINACAO
    @GetMapping
    public ResponseEntity<List<Orders>> findAll(@RequestParam (required = false)Integer pagina,
                                                @RequestParam(required = false)Integer qtdRegistros)
            throws Exception{
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(ordersService.findAll(pagina,qtdRegistros),headers,HttpStatus.OK);
    }

    //COM VO
    @GetMapping("/listar-todos")
    public ResponseEntity<List<OrdersVO>> findAllVO(
            @RequestParam(required = false) Integer pagina,
            @RequestParam(required = false) Integer qtdRegistros)
            throws Exception {

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(ordersService.findAllVO(pagina,
                qtdRegistros), headers, HttpStatus.OK);
    }

    @GetMapping("/count")
    public Long count() {
        return ordersService.count();
    }


    @PostMapping("/save")
    public ResponseEntity<Orders> save(@RequestBody Orders orders){
        //return alunoService.save(aluno);
        HttpHeaders headers = new HttpHeaders();

        if(null != ordersService.save(orders))
            return new ResponseEntity<Orders>(ordersService.save(orders), headers, HttpStatus.OK);
        else
            return new ResponseEntity<Orders>(ordersService.save(orders), headers, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public Orders update(@RequestBody Orders orders){

        return ordersService.update(orders);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Orders> delete(@RequestParam Integer id){
        HttpHeaders headers = new HttpHeaders();
        boolean isRemoved = ordersService.delete(id);
        if (isRemoved){
            return new ResponseEntity<>(headers,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(headers,HttpStatus.BAD_REQUEST);

        }

    }

    @GetMapping("/nf/{id}")
    public ResponseEntity<NotaFiscalVO> NFfindById(@PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(ordersService.NFfindById(id),headers,HttpStatus.OK);
    }





//    @PostMapping ("/saveVO")
//    public ResponseEntity<OrdersVO> save(@RequestBody OrdersVO ordersVO){
//        HttpHeaders headers = new HttpHeaders();
//
//        OrdersVO novoOrdersVO = ordersService.save(ordersVO);
//
//        if(null != novoOrdersVO)
//            return new ResponseEntity<>(novoOrdersVO, headers, HttpStatus.OK);
//        else
//            return new ResponseEntity<>(novoOrdersVO, headers, HttpStatus.BAD_REQUEST);
//    }
}
