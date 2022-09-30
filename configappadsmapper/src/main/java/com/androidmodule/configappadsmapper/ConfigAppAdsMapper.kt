package com.androidmodule.configappadsmapper

import com.adsmanager.core.ConfigAds
import com.adsmanager.core.NetworkAds
import com.androidmodule.configapp.domain.ConfigApp

object ConfigAppAdsMapper {

    fun mapFromConfigApp(configApp: ConfigApp) {
        ConfigAds.isShowAds = configApp.isShowAds == true
        ConfigAds.isShowOpenAd = configApp.isShowOpenAd == true
        ConfigAds.isShowBanner = configApp.isShowBanner == true
        ConfigAds.isShowInterstitial = configApp.isShowInterstitial == true
        ConfigAds.isShowNativeAd = configApp.isShowNativeAd == true
        ConfigAds.isShowRewards = configApp.isShowRewards == true

        configApp.intervalTimeInterstitial?.let { ConfigAds.intervalTimeInterstitial = it }

        configApp.primaryOpenAdId?.let { ConfigAds.primaryOpenAdId = it }
        configApp.secondaryOpenAdId?.let { ConfigAds.secondaryOpenAdId = it }
        configApp.tertiaryOpenAdId?.let { ConfigAds.tertiaryOpenAdId = it }
        configApp.quaternaryOpenAdId?.let { ConfigAds.quaternaryOpenAdId = it }

        configApp.primaryAds?.let {
            handleNetworkAds(it)?.let { networkAds ->
                ConfigAds.primaryAds = networkAds
            }
        }
        configApp.secondaryAds?.let { ConfigAds.secondaryAds = handleNetworkAds(it) }
        configApp.secondaryAds?.let { ConfigAds.secondaryAds = handleNetworkAds(it) }
        configApp.tertiaryAds?.let { ConfigAds.tertiaryAds = handleNetworkAds(it) }
        configApp.quaternaryAds?.let { ConfigAds.quaternaryAds = handleNetworkAds(it) }


        configApp.primaryAppId?.let { ConfigAds.primaryAppId = it }
        configApp.secondaryAppId?.let { ConfigAds.secondaryAppId = it }
        configApp.tertiaryAppId?.let { ConfigAds.tertiaryAppId = it }
        configApp.quaternaryAppId?.let { ConfigAds.quaternaryAppId = it }

        configApp.primaryBannerId?.let { ConfigAds.primaryBannerId = it }
        configApp.secondaryBannerId?.let { ConfigAds.secondaryBannerId = it }
        configApp.tertiaryBannerId?.let { ConfigAds.tertiaryBannerId = it }
        configApp.quaternaryBannerId?.let { ConfigAds.quaternaryBannerId = it }

        configApp.primaryInterstitialId?.let { ConfigAds.primaryInterstitialId = it }
        configApp.secondaryInterstitialId?.let { ConfigAds.secondaryInterstitialId = it }
        configApp.tertiaryInterstitialId?.let { ConfigAds.tertiaryInterstitialId = it }
        configApp.quaternaryInterstitialId?.let { ConfigAds.quaternaryInterstitialId = it }

        configApp.primaryNativeId?.let { ConfigAds.primaryNativeId = it }
        configApp.secondaryNativeId?.let { ConfigAds.secondaryNativeId = it }
        configApp.tertiaryNativeId?.let { ConfigAds.tertiaryNativeId = it }
        configApp.quaternaryNativeId?.let { ConfigAds.quaternaryNativeId = it }

        configApp.primaryRewardsId?.let { ConfigAds.primaryRewardsId = it }
        configApp.secondaryRewardsId?.let { ConfigAds.secondaryRewardsId = it }
        configApp.tertiaryRewardsId?.let { ConfigAds.tertiaryRewardsId = it }
        configApp.quaternaryRewardsId?.let { ConfigAds.quaternaryRewardsId = it }

    }

    private fun handleNetworkAds(networkAds: String): NetworkAds? {
        return when (networkAds) {
            "Admob" -> NetworkAds.ADMOB
            "Fan" -> NetworkAds.FAN
            "Applovin-Max" -> NetworkAds.APPLOVIN_MAX
            "Applovin-Discovery" -> NetworkAds.APPLOVIN_DISCOVERY
            "StartIo" -> NetworkAds.START_IO
            else -> null
        }
    }
}