package com.gentics.cailun.core.rest.service;

import java.util.List;

import com.gentics.cailun.core.rest.model.Content;
import com.gentics.cailun.core.rest.model.Language;
import com.gentics.cailun.core.rest.response.GenericContentResponse;
import com.gentics.cailun.core.rest.service.generic.GenericContentService;

public interface ContentService extends GenericContentService<Content> {

	public void setTeaser(Content page, Language language, String text);

	public void setTitle(Content page, Language language, String text);

	public GenericContentResponse getReponseObject(Content content, List<String> languages);

}
