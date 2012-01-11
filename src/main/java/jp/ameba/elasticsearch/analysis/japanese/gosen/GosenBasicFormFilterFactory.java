package jp.ameba.elasticsearch.analysis.japanese.gosen;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.ja.JapaneseBasicFormFilter;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;
import org.elasticsearch.index.settings.IndexSettings;

public class GosenBasicFormFilterFactory extends AbstractTokenFilterFactory {
	
	@Inject
	public GosenBasicFormFilterFactory(
			Index index,
			@IndexSettings Settings indexSettings,
			@Assisted String name,
			@Assisted Settings settings) {
		super(index, indexSettings, name, settings);
	}

	@Override
	public TokenStream create(TokenStream stream) {
		return new JapaneseBasicFormFilter(stream);
	}

}
