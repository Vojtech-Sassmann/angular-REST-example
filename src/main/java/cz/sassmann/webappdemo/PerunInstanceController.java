package cz.sassmann.webappdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vojtech Sassmann <vojtech.sassmann@gmail.com>
 */
@RequestMapping(path = "perunInstances")
@RestController
public class PerunInstanceController {

	private Logger LOG = LoggerFactory.getLogger(PerunInstanceController.class);

	private static final Map<Long, PerunInstance> instances = new HashMap<>();
	private static Long counter = 1L;
	static {
		addInstance(new PerunInstance("Michal Stava", "perun.cesnet.cz", "3.4.5"));
		addInstance(new PerunInstance("Martin Kuba", "perun-dev.cesnet.cz", "3.5.0"));
		addInstance(new PerunInstance("Pavel Zlamal", "perun.muni.cz", "3.4.5"));
	}

	@GetMapping
	public ResponseEntity<List<PerunInstance>> perunInstances() {
		LOG.info("perunInstaces() called.");

		return ResponseEntity.ok(new ArrayList<>(instances.values()));
	}

	@PostMapping
	public ResponseEntity<PerunInstance> createPerunInstance(@RequestBody PerunInstance instance) {
		LOG.info("createPerunInstance({}) called.", instance);

		addInstance(instance);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(instance.getId())
				.toUri();

		return ResponseEntity.created(location).body(instance);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deletePerunInstance(@PathVariable Long id) {
		LOG.info("deletePerunInstance({}) called.", id);

		if (!instances.containsKey(id)) {
			return ResponseEntity
					.notFound()
					.location(ServletUriComponentsBuilder
							.fromCurrentRequest()
							.buildAndExpand()
							.toUri())
					.build();
		}

		instances.remove(id);

		return ResponseEntity
				.ok()
				.location(ServletUriComponentsBuilder
						.fromCurrentRequest()
						.build()
						.toUri())
				.build();
	}

	private static void addInstance(PerunInstance instance) {
		Long id = counter++;
		instance.setId(id);
		instances.put(id, instance);
	}
}
