import {Routes} from "@angular/router";
import {MainComponent} from './views/view'

export const ROUTES:Routes = [
    // Main redirect
    {path: '', redirectTo: 'mainView', pathMatch: 'full'},

    // App views
    {path: 'mainView', component: MainComponent},
    // {path: 'mainView', component: mainViewComponent,
    //     children: [
    //         {path: '', component: DashboardComponent},
    //         {path: 'dashboardView', component: DashboardComponent},
    //         {path: 'minorView', component: minorViewComponent},
    //         {path: 'atendimentoView', component: AtendimentoComponent},
    //     ]
    // },
  /*  {path: 'minorView', component: minorViewComponent},*/

    // Handle all other routes
    // {path: '**',    component: mainViewComponent}
];
