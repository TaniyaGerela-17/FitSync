import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NzMessageService } from 'ng-zorro-antd/message';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-activity',
  templateUrl: './activity.component.html',
  styleUrls: ['./activity.component.css']
})
export class ActivityComponent {

  gridStyle = {
    width: '100%',
    textAlign: 'center'
  };

  activityForm!: FormGroup;
  activities:any;

  // ⏱️ Timer state
  timer: any;
  elapsedTime: number = 0;
  isRunning: boolean = false;
  displayTime: string = '00:00:00';

  constructor(private fb: FormBuilder, private message: NzMessageService, private userService: UserService){}

  ngOnInit(){
    this.activityForm = this.fb.group({
      caloriesBurned: [null, [Validators.required]],
      steps: [null, [Validators.required]],
      distance: [null, [Validators.required]],
      date: [null, [Validators.required]],
    });

    this.getAllActivities();
  }

  // ⏱️ Timer Functions
  startTimer(): void {
    this.isRunning = true;
    this.timer = setInterval(() => {
      this.elapsedTime++;
      this.displayTime = this.formatTime(this.elapsedTime);
    }, 1000);
  }

  pauseTimer(): void {
    clearInterval(this.timer);
    this.isRunning = false;
  }

  resetTimer(): void {
    clearInterval(this.timer);
    this.elapsedTime = 0;
    this.displayTime = '00:00:00';
    this.isRunning = false;
  }

  private formatTime(totalSeconds: number): string {
    const hrs = Math.floor(totalSeconds / 3600);
    const mins = Math.floor((totalSeconds % 3600) / 60);
    const secs = totalSeconds % 60;
    return `${this.pad(hrs)}:${this.pad(mins)}:${this.pad(secs)}`;
  }

  private pad(val: number): string {
    return val < 10 ? '0' + val : val.toString();
  }

  submitForm(){
    this.userService.postActivity(this.activityForm.value).subscribe(res=>{
      this.message.success("Activity posted successfully", {nzDuration: 5000});
      this.activityForm.reset();
      this.getAllActivities();
    }, error=>{
      this.message.error("Error while posting Activity", {nzDuration: 5000});
    })
  }

  getAllActivities(){
    this.userService.getActivities().subscribe(res=>{
      this.activities = res;
      console.log(this.activities);
    })
  }

}
