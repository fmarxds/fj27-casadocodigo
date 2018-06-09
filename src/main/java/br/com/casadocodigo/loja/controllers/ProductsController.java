package br.com.casadocodigo.loja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.daos.ProductDao;
import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.models.Product;

@Controller
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private ProductDao productDao;
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		binder.addValidators(new ProductValidator());
//	}
	
	@RequestMapping("/form")
	public ModelAndView form(Product product) {
		ModelAndView mv = new ModelAndView("products/form");
		mv.addObject("types", BookType.values());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Product product, BindingResult result, RedirectAttributes attrs) {
		
		if(result.hasErrors()) {
			return form(product);
		}
		
		productDao.save(product);
		attrs.addFlashAttribute("sucesso", "Cadastrado com sucesso");
		return new ModelAndView("redirect:/products");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("products/list");
		mv.addObject("products", productDao.list());
		return mv;
	}

}
