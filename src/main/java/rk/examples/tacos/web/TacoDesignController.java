package rk.examples.tacos.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import rk.examples.tacos.Ingredient;
import rk.examples.tacos.Taco;
import rk.examples.tacos.Ingredient.Type;

@Slf4j
@Controller
@RequestMapping("/design")
public class TacoDesignController {

	@GetMapping
	public String showDesignForm(Model model) {
		List<Ingredient> ingredients = List.of(new Ingredient("FLTO", "Flour Tortila", Type.WRAP),
				new Ingredient("COTO", "Corn Tortila", Type.WRAP), new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
				new Ingredient("CARN", "Carnitas", Type.PROTEIN),
				new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES), new Ingredient("LETC", "Lettuce", Type.VEGGIES),
				new Ingredient("CHED", "Cheddar", Type.CHEESE), new Ingredient("JACK", "Monterrry Jack", Type.CHEESE),
				new Ingredient("SLSA", "Salsa", Type.SAUCE), new Ingredient("SRCR", "Sour Cream", Type.SAUCE));

		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(), filterByIngredientType(ingredients, type));
		}
		
		model.addAttribute("design", new Taco());

		return "design";
	}
	
	@PostMapping
	public String processDesign(Taco design) {
		//TODO: Save to Database;
		log.info("Processing {}", design);
		return "redirect:/orders/current";
	}
	
	private List<Ingredient> filterByIngredientType(List<Ingredient> ingredients, Type type) {
		return ingredients.stream().filter(e -> e.getType().equals(type)).collect(Collectors.toList());
	}
}
