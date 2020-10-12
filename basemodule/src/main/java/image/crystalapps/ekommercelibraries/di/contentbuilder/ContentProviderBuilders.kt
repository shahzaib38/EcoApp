package image.crystalapps.ekommercelibraries.di.contentbuilder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import image.crystalapps.ekommercelibraries.contentproviders.BaseContentProvider


@Module
abstract class ContentProviderBuilders {




    @ContributesAndroidInjector
    abstract fun contributeBaseContentProvider() : BaseContentProvider

}