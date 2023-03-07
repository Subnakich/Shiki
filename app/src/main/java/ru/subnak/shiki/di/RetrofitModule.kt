package ru.subnak.shiki.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import ru.subnak.shiki.BuildConfig
import ru.subnak.shiki.data.network.interceptor.UserAgentInterceptor
import ru.subnak.shiki.utils.Constants
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
interface RetrofitModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor? {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideUserAgentInterceptor(): UserAgentInterceptor? {
        return UserAgentInterceptor()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        userAgentInterceptor: UserAgentInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(userAgentInterceptor)
            .connectTimeout(Constants.TIMEOUT_DEFAULT, TimeUnit.SECONDS)
            .readTimeout(Constants.TIMEOUT_DEFAULT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitBuilder(
        factory: Converter.Factory,
        okHttpClient: OkHttpClient
    ): Retrofit.Builder {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(factory)
    }

    @Provides
    @Singleton
    fun provideRetrofit(retrofitBuilder: Retrofit.Builder): Retrofit? {
        return retrofitBuilder.baseUrl(BuildConfig.ShikimoriBaseUrl).build()
    }
}