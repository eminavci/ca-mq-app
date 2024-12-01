import { Routes } from '@angular/router';
import { PartnerComponent } from './components/partner/partner.component';
import { QmComponent } from './components/qm/qm.component';

export const routes: Routes = [
    {
        path: '',
        redirectTo: 'partner',
        pathMatch: 'full'

    },

    {
        path: 'partner',
        component: PartnerComponent
    },

    {
        path: 'qm',
        component: QmComponent
    }

];
