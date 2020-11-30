package image.crystalapps.kecommerce.ui.address

import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.data.network.firebase.ServerFunctions
import image.crystalapps.kecommerce.model.Address
import image.crystalapps.kecommerce.ui.base.BaseRepository
import image.crystalapps.kecommerce.utils.QueryLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AddressRepository @Inject constructor( val serverFunctions : ServerFunctions , val dataManager: DataManager) : BaseRepository() ,ServerFunctions by serverFunctions ,DataManager by dataManager {

    override fun save(address: Address) {
        serverFunctions.save(address) }




}