import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NzMessageService } from 'ng-zorro-antd/message';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-goal',
  templateUrl: './goal.component.html',
  styleUrls: ['./goal.component.css']
})
export class GoalComponent {

  gridStyle = {
    width: '100%',
    textAlign: 'center'
  };
  
  goalForm!: FormGroup;
  goals:any;
    
  
  constructor(private fb: FormBuilder, private message: NzMessageService, private userService: UserService){}
  
  ngOnInit(){
    this.goalForm = this.fb.group({
      description: [null, [Validators.required]],
      startDate: [null, [Validators.required]],
      endDate: [null, [Validators.required]],
    });

    this.getAllGoals();
  }

  submitForm(){
    this.userService.postGoal(this.goalForm.value).subscribe(res=>{
      this.message.success("Goal posted successfully", {nzDuration : 5000});
      this.goalForm.reset();
      this.getAllGoals();
    },error=>{
      this.message.error("Error while posting goal", {nzDuration : 5000});
    });
  }

  getAllGoals(){
    this.userService.getGoals().subscribe(res=>{
      this.goals = res;
      console.log(this.goals);
    })
  }

  updateStatus(id: number){
    this.userService.updateGoalStatus(id).subscribe(res=>{
      this.message.success("Goal updated successfully", {nzDuration : 5000});
      this.getAllGoals();
    },error=>{
      this.message.error("Error while updating goal", {nzDuration : 5000});
    });
  }
}
