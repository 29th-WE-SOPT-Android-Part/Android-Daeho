# week2 - SOPTHub Repository Page

## **실행 예시**

<img src= "https://user-images.githubusercontent.com/69508245/138457013-db39c9d6-65c3-467e-b46e-e853731733e1.png" width = "300" height="450"/>  <img src= "https://user-images.githubusercontent.com/69508245/138457138-60911b81-d5f0-428f-a905-8b1d712909cb.png" width = "300" height="450"/> 



## **Level 1**
**Recyclerview를 제작하여 만들어준 fragment에 넣기** 
  
   
   ### UserData & RepoData class 제작
   
   - 제작한 Layout에 값을 넣어주기 위해 DataClass를 제작하였다. 
   ```kotlin
       data class RepoData(
        val name : String,
        val explanation : String
      )
      
        data class UserData(
      val name : String,
      val introduction : String
      )
   ```
   
   ### layout 값 변경 
   - Dataclass의 값을 변경하는 함수이다. 
   ```kotlin
       private fun initAdapter(){
        followerAdapter = FollowerAdapter()

        binding.rvFollower.adapter = followerAdapter

        followerAdapter.userList.addAll(
            listOf(
                UserData(name = "김대호", introduction = "나는 김대호"),
                UserData(name = "남대호", introduction = "나는 남대호"),
                UserData(name = "담대호", introduction = "나는 담대호")
            )
        )

        followerAdapter.notifyDataSetChanged()
    }
   
   ```
   ### 버튼으로 fragment 제어
   - 각각 버튼마다 transaction을 걸어주었다. 
  ```kotlin
          binding.btnFollow.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            transaction.replace(R.id.container_main, fragment1)

            transaction.commit()
        }

        binding.btnRepo.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            transaction.replace(R.id.container_main, fragment2)

            transaction.commit()
        }
  
  ```
  

   ### Adapter 제작 
   - viewholder에 recyclerview layout을 넣어주기 위해 adpater를 제작하였다. 
     ```kotlin
    class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {
      val userList = mutableListOf<UserData>()

      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
      ): FollowerViewHolder {
          val binding = ItemFollowListBinding.inflate(LayoutInflater.from(parent.context),
          parent, false)

          return FollowerViewHolder(binding)
      }

      override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
          holder.onBind(userList[position])
      }


      override fun getItemCount(): Int = userList.size

      class FollowerViewHolder (private val binding: ItemFollowListBinding)
          : RecyclerView.ViewHolder(binding.root){
          fun onBind(data : UserData){
              binding.tvName.text = data.name
              binding.tvIntroduce.text = data.introduction
          }


      }
  }
 
    
   
## 배운 것 
1. Recyclerview, adapter, layout 제작관계  
2. fragment의 생명주기 
3. list, grid layout 제작  

