package image.crystalapps.kecommerce.di.contentbuilder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import image.crystalapps.kecommerce.contentproviders.BaseContentProvider


@Module
abstract class ContentProviderBuilders {




    @ContributesAndroidInjector
    abstract fun contributeBaseContentProvider() : BaseContentProvider

}