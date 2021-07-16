package com.example.data.di

import com.example.data.serialization.MoshiUserListAdapter
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single { provideMoshi() }

    single { provideMoshiConverter(get()) }

    single { provideOkHttpClient() }

    single { provideRetrofit(get(), "https://cryptic-reef-02597.herokuapp.com", get()) }
}


private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .build()
} else OkHttpClient
    .Builder()
    .build()

private fun provideRetrofit(
    okHttpClient: OkHttpClient,
    baseURL: String,
    moshiConverterFactory: MoshiConverterFactory
): Retrofit =
    Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(
            moshiConverterFactory
        )
        .client(okHttpClient)
        .build()

private fun provideMoshiConverter(
    moshi: Moshi
): MoshiConverterFactory = MoshiConverterFactory.create(moshi)

private fun provideMoshi() = Moshi.Builder()
    .add(MoshiUserListAdapter())
    .build()


