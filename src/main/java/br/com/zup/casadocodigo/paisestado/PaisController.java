package br.com.zup.casadocodigo.paisestado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class PaisController {

	@PersistenceContext
	EntityManager manager;

	@PostMapping
	@Transactional
	public String criaPais(@RequestBody @Valid NovoPaisRequest request) {
		Pais novoPais = request.toModel();
		manager.persist(novoPais);
		return novoPais.toString();
	}

}
