package br.espm.cambio;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.espm.cambio.COTACAO.Cotacao;
import br.espm.cambio.COTACAO.CotacaoService;
import br.espm.cambio.MOEDA.Moeda;
import br.espm.cambio.MOEDA.MoedaService;

@RestController
public class CambioResource {

@Autowired
private MoedaService moedaService;

@Autowired
private CotacaoService cotacaoService;
  
    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello ESPM! :)";
    }

    @GetMapping("/moeda")
    public List<Moeda> listMoeda(){
        return moedaService.listAll();        
    }


    @GetMapping("/moeda/{simbolo:[A-Z]{3,}}")
    public Moeda findMoedaBySimbolo(@PathVariable String simbolo) {
        return moedaService.findBySimbolo(simbolo);
    }

    @GetMapping("/moeda/{id:[a-f0-9]{8}(?:-[a-f0-9]{4}){4}[a-f0-9]{8}}")
    public Moeda findMoedaById(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        return moedaService.findById(uuid);
    }


    @PostMapping("/moeda")
    public void save(@RequestBody Moeda moeda){
        moedaService.create(moeda);
    }

    @DeleteMapping("moeda/{id:[a-f0-9]{8}(?:-[a-f0-9]{4}){4}[a-f0-9]{8}}")
    public void DeleteMoedaById(@PathVariable String id){
        UUID uuid = UUID.fromString(id);
        moedaService.DeleteById(uuid);
    }

    @RequestMapping(path ="/cotacao/{simbolo}/{ano}/{mes}/{dia}" , method = RequestMethod.POST)
    public void savecotacao(@PathVariable String simbolo , @PathVariable String ano, @PathVariable String mes ,@PathVariable String dia , @RequestBody String valor) {
    LocalDate data = LocalDate.parse(ano +"." +mes+"." + dia);
    UUID moeda = moedaService.findBySimbolo(simbolo).getId(); 
    String valorDouble = valor.replaceAll("[^0-9,.]", "");  
    Double valorDoublefinal = Double.parseDouble(valorDouble);
     Cotacao cotacao = new Cotacao(moeda, data, valorDoublefinal); 
     cotacaoService.create(cotacao);   
    }

    @GetMapping("/cotacao/{simbolo:[A-Z]{3,}}")
    public List<Cotacao> ListCotacaoBySimbolo(@PathVariable String simbolo){
       UUID id = moedaService.findBySimboloId(simbolo);
       return cotacaoService.listAll(id);        
    }
  
}
