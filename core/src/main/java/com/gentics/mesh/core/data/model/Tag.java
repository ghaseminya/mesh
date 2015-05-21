package com.gentics.mesh.core.data.model;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import com.gentics.mesh.core.data.model.generic.GenericPropertyContainer;
import com.gentics.mesh.core.data.model.relationship.BasicRelationships;

/**
 * A tag is the main structural element. It allows the creation of tag hierarchies. Tags have important limitations. A tag can and must only have one parent.
 * 
 * @author johannes2
 *
 */
@NodeEntity
public class Tag extends GenericPropertyContainer {

	private static final long serialVersionUID = 7645315435657775862L;

	private static Label label = DynamicLabel.label(Tag.class.getSimpleName());

	public Tag() {

	}

	public static Label getLabel() {

		/**
		 * TODO check whether the CallerSensitive annotation could be used to move this method into an abstract class?
		 * 
		 * @CallerSensitive public static Package getPackage(String name) { ClassLoader l = ClassLoader.getClassLoader(Reflection.getCallerClass());
		 */
		return label;
	}

	@RelatedTo(type = BasicRelationships.HAS_TAG, direction = Direction.INCOMING, elementClass = MeshNode.class)
	private Set<MeshNode> nodes = new HashSet<>();

	public Set<MeshNode> getNodes() {
		return nodes;
	}

	public boolean removeNode(MeshNode node) {
		return nodes.remove(node);
	}
}
