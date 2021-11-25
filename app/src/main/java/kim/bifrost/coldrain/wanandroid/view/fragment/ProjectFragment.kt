package kim.bifrost.coldrain.wanandroid.view.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import kim.bifrost.coldrain.wanandroid.databinding.FragmentHomeBinding
import kim.bifrost.coldrain.wanandroid.databinding.FragmentSystemBinding
import kim.bifrost.coldrain.wanandroid.databinding.FragmentWechatBinding


class ProjectFragment : BaseFragment<FragmentSystemBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        boolean: Boolean
    ): FragmentSystemBinding = FragmentSystemBinding.inflate(inflater, container, false)
}