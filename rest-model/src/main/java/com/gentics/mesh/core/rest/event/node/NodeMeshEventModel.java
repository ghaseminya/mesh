package com.gentics.mesh.core.rest.event.node;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gentics.mesh.core.rest.MeshEvent;
import com.gentics.mesh.core.rest.event.AbstractProjectEventModel;
import com.gentics.mesh.core.rest.event.EventCauseInfo;
import com.gentics.mesh.core.rest.project.ProjectReference;
import com.gentics.mesh.core.rest.schema.SchemaReference;
import com.gentics.mesh.core.rest.schema.impl.SchemaReferenceImpl;

public class NodeMeshEventModel extends AbstractProjectEventModel {

	@JsonProperty(required = false)
	@JsonPropertyDescription("Type of the content (e.g. draft/published)")
	private String type;

	@JsonProperty(required = true)
	@JsonPropertyDescription("Branch uuid to which the node belongs.")
	private String branchUuid;

	@JsonProperty(required = true)
	@JsonPropertyDescription("Version of the node content.")
	private String version;

	@JsonProperty(required = false)
	@JsonPropertyDescription("ISO 639-1 language tag of the node content.")
	private String languageTag;

	@JsonProperty(required = false)
	@JsonPropertyDescription("Schema reference of the node.")
	@JsonDeserialize(as = SchemaReferenceImpl.class)
	private SchemaReference schema;

	@JsonCreator
	public NodeMeshEventModel(String origin, EventCauseInfo cause, MeshEvent event, String uuid, String name, ProjectReference project, String type,
		String branchUuid, String version, String languageTag, SchemaReference schema) {
		super(origin, cause, event, uuid, name, project);
		this.type = type;
		this.branchUuid = branchUuid;
		this.version = version;
		this.languageTag = languageTag;
		this.schema = schema;
	}

	/**
	 * Type of the node that has been deleted (e.g. published or draft)
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBranchUuid() {
		return branchUuid;
	}

	public void setBranchUuid(String branchUuid) {
		this.branchUuid = branchUuid;
	}

	/**
	 * Return the specific language tag that has been deleted from the node.
	 * 
	 * @return
	 */
	public String getLanguageTag() {
		return languageTag;
	}

	public void setLanguageTag(String languageTag) {
		this.languageTag = languageTag;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public SchemaReference getSchema() {
		return schema;
	}

	public void setSchema(SchemaReference schema) {
		this.schema = schema;
	}
}
