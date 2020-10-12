package image.crystalapps.kecommerce.ui.productselection.dialogfragment

import image.crystalapps.ekommercelibraries.ui.base.BaseViewModel
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.di.activitiesbuilder.FragmentScope
import javax.inject.Inject

@FragmentScope
class FilterViewModel @Inject constructor(val dataManager: DataManager) :BaseViewModel<FilterNavigator>(dataManager)







