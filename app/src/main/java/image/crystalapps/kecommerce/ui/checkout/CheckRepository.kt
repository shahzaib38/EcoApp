package image.crystalapps.kecommerce.ui.checkout

import com.google.android.gms.common.api.internal.BasePendingResult
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.model.Address
import image.crystalapps.kecommerce.ui.base.BaseRepository
import image.crystalapps.kecommerce.utils.AddressLiveData
import image.crystalapps.kecommerce.utils.QueryLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CheckRepository @Inject  constructor(val dataManager: DataManager) :BaseRepository() ,DataManager by dataManager {

    override fun getAddress(): AddressLiveData<Address> = dataManager.getAddress()


}