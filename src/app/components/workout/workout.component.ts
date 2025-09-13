import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NzMessageService } from 'ng-zorro-antd/message';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-workout',
  templateUrl: './workout.component.html',
  styleUrls: ['./workout.component.css']
})
export class WorkoutComponent {

  gridStyle = {
    width: '100%',
    textAlign: 'center'
  };

  workoutForm!: FormGroup;

  listOfType: any[] = [
    "Cardio",
    "Strength",
    "Flexibility",
    "HIIT",
    "Pilates",
    "Dance",
    "Swimming",
    "Cycling",
    "Running",
    "Walking",
    "Boxing",
    "CrossFit",
    "Rowing",
    "Stretching",
    "Martial Arts",
    "Symmastics",
    "Climbing",
    "Plyometrics"
  ];

  workouts:any;
  totalCalories = 0;
  totalDuration = 0;
  workoutsPerType: any = {};
  caloriesChartData: any[] = [];
  durationChartData: any[] = [];
  aiSuggestions: string[] = []; // Placeholder for AI-generated suggestions


  constructor(private fb:FormBuilder,
    private userService: UserService,
    private message: NzMessageService
  ){

  }

  ngOnInit(){
    this.workoutForm = this.fb.group({
      type: [null, [Validators.required]],
      duration: [null, [Validators.required]],
      date: [null, [Validators.required]],
      caloriesBurned: [null, [Validators.required]]
    });
    this.getWorkouts();
  }

  getWorkouts(){
    this.userService.getWorkouts().subscribe(res=>{
      this.workouts = res;
    })
  }

  submitForm(){
    this.userService.postWorkout(this.workoutForm.value).subscribe(res=>{
      this.message.success("Workout posted successfully", {nzDuration : 5000});
      this.workoutForm.reset();
      this.getWorkouts();
    },error=>{
      this.message.error("Error while posting workout", {nzDuration : 5000});
    });
  }

  

}
